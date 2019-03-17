# StudyFragment
- [Android Docs](https://developer.android.com/guide/components/fragments?hl=ko) 및 여러가지 사이트를 참고하여 Fragment에 대한 공부 정리 Markdown

1. What?, Fragment란?

   - 하나의 액티비티가 여러 개의 화면을 가지도록 만들기위해 고안된 개념
   - 태블릿은 일반 스마트폰과 다르게 크기가 달라 유동적인 UI를 구현하기 위해서 나온 개념.

2. Why? 왜 사용해야 하는가

   ![](https://developer.android.com/images/fundamentals/fragments.png?hl=ko)

   - Android 초창기, 프래그먼트는 없었고 오직 Activity와 View로만 구성됨
   - [ActivityGroup](https://developer.android.com/reference/android/app/ActivityGroup)이 초창기 안드로이드에 있었는데, 이 ActivityGroup는 Activity 역할은 제대로 못하면서 무겁기도 하고 Binder 통신에도 문제가 있는 등... 여러가지 문제가 있었지만 사용했음
     - WHY?? : 코드 분리, View 하나로 되긴 되는데 굳이 ActivityGroup 내에 Activity를 둔 건, 라이프사이클 메서드가 있었기 때문에 사용
     - View가 LifeCycle Callback을 받을 수 있어서 클래스 자체에서 View를 관리할수 있다면 어떨까.
     - 근데 그럴거면 그냥 View를 LifeCycle을 가지게 하면 되지 않나? : View 자체가 라이프사이클을 타지 않게 만듬, View는 보여줘야되는데 LifeCycle 타면 이상하지 않은가?
     - 그래서 이런 모든것을 합친게 Fragment(API 11), ActivityGroup은 이후로 API 13에서 deprecated 됨.

   - 프래그먼트를 디자인할 때에는 각 프래그먼트를 모듈식이며 재사용 가능한 액티비티 구성 요소로 만들어야 한다
     - 각 프래그먼트가 나름의 레이아웃을 따로 정의하고 자기만의 수명 주기 콜백으로 자기 나름의 동작을 정의하기 때문에 한 프래그먼트를 여러 액티비티에 포함이 가능하다

3. Fragment LifeCycle

   - 그래서 View가 생명주기를 가지게 하려고 했단거고, 그래서 Fragment가 나온거면, 어떤 생명주기를 가지고 있는가??

   ![](https://developer.android.com/images/fragment_lifecycle.png?hl=ko)

   - onCreate, onStart, onRestart, onResume, onPause, onStop, onDestroy - 액티비티에도 있는 생명주기 (추후 액티비티 생명주기 정리) (Fragment에서 새롭게 추가되면 추가 정리)
   - onAttach() : Fragment가 Activity에 attach될때 호출
   - onCreate() : 초기화해야하는 리소스를 여기서 추가하지만, UI 초기화는 여기서 안 함
   - onCreateView() : Layout Inflate 하는 위치이며, CreateView에서 UI 초기화를 함

   - onActivityCreated() :Activity - onCreate를 마친 후(즉 onCreate()가 반환된 후)이므로 UI는 초기화가 되어 있기 때문에, UI.View를 변경할 수 있음.
   - onDestroyView() : CreateView로 생성된 (즉, Fragment와 관련된) View를 제거하는 단계
   - onDetach() : Fragment가 Activity에서 detach될 때 호출됨