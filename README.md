# Offset ListView

An modified `ListView` that supports setting offset relative to top and bottom of the `ListView` content, useful when using `ActionBarOverlay` etc..


## Installation

Import `library` folder as a Android library project and add dependency in your projects, use attribute like in this example:

```xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/frame"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <org.pirriperdos.offsetscroll.OffsetListView
        android:id="@+id/main_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:scrollBarPaddingBottom="96dp"
        app:scrollBarPaddingTop="48dp"
        tools:context=".MainActivity" />
</FrameLayout>
```