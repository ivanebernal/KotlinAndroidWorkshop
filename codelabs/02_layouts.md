# Layouts

Commit number: 4f639c5

In this lesson we'll create our app's layouts. Our app will be a simple list of contacts. 
We will display the list and then choose a contact to know it's details.

## Adding dependencies
First things first, we need to tell our project that we want to use two things that aren't there by default:
RecyclerView and CardView. For this we nned to go to the `build.gradle (Module: app)` file and under the `dependencies`
brackets paste the following:

```
compile 'com.android.support:cardview-v7:26.0.0'
compile 'com.android.support:recyclerview-v7:26.0.0'
```

Note that the version may change depending on the `com.android.support:appcompat-v7` dependency.

The IDE will ask us to rebuild our project and doing that will add the dependencies we nned.

## Using XML
Go to the activity_main.xml file and at the bottom of the screen you'll see two tabs: Design and Text. 
We'll focus on text for now. Go there and copy the following:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.ivanebernal.summertalksapp.MainActivity">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/contact_list"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

Each View in our screen is represented by an XML tag, for example `<LinearLayout><LinearLayout/>`. 
XML uses a hierarchy format, meaning that the outmost View of all is the parent of the inner views. In this case `LinearLayout`
is the parent of `android.support.v7.widget.RecyclerView`. This is useful when we declare attributes that are relative to
the view's parent, for example `android:layout_width="match_parent"` and `android:layout_height="match_parent"`

Many attributes are available depending on the view, but the most important ones are `android:layout_width`,
`android:layout_height` and `android:id`. 

`android:layout_marginStart` and `android:layout_marginEnd` gives the view spacing to left and right. As you can see, 
the units we use for size in Android are dp and sp.

* **dp** (Density-independent Pixels): it's an abstract unit which is based on the density of the screen, 
which means that the real value of one unit changes depending on the screen density avoiding drastic size changes between
different densities.
* **sp** (Scale-independent Pixels): like dp but the user's system-wide preferred font size is also taken into consideration.
Because of this, sp is used when specifying font sizes.

A Layout is a container view which holds the child views in an specific order. There are many types of layouts, but the most
used ones are the following:

* **LinearLayout**: Arranges its child views in a linear way in the order they are written, depending on the 
`android:orientation` attribute they can be aligned vertically or horizontally.

* **FrameLayout**: Child views are arranged in a way that the uppermost view is behind all the views and the downmost view is
on top of all the views.

* **RelativeLayout**: In this Layout `android:id` is very important, each view can be arranged relative to sibling and parent views.

* **ConstraintLayout**: This Layout allows for a more responsive UI. Each view is constrained to a sibling view or the
parent view, like a RelativeLayout but it's more flexible and easier to use in the Layout Editor (Design tab). This type of
Layout works very similar to the iOS Layout Editor.

The preview look of this XML is very simple. We will need to make another file for the views that we want to be repeated
on the list. We will call these files "View Holders."

## Creating a View Holder
We'll now create a new XML file. Right-click the `layout` folder on the left of the screen and select __New__>__Layout resource file__.

<a href="https://ibb.co/evHJpk"><img src="https://preview.ibb.co/jKNjUk/Screen_Shot_2017_07_28_at_11_04_45_PM.png" alt="Screen_Shot_2017_07_28_at_11_04_45_PM" border="0"></a><br />

We'll just change the Root element to `android.support.constraint.ConstraintLayout` and name the file `holder_contact`. 
I personally use form holder_<object>, activity_<name>, fragment_<name> to keep my `layout` folder organized, 
this way all the holders, activities and fragments are arranged in alphabetical order and grouped by category.

The Layout editor looks like this:

<a href="https://ibb.co/mghMaQ"><img src="https://preview.ibb.co/nDJuvQ/Screen_Shot_2017_07_28_at_11_10_45_PM.png" alt="Screen_Shot_2017_07_28_at_11_10_45_PM" border="0"></a><br />

On the left side we have the views grouped by category and the Component Tree, which is a draft of the hierarchy of the views.
On the right side we have the attributes that the selected view has, depending on the view, this section might look different.
On top of the editor we have different ConstrainLayout tools like pack, align, guidelines; and on top of that we have appearance
tools like change device, api, theme. The editor allows us to arrange the views dragging and dropping them where we want. You'll
see two screens, on the left we have how the screen will actually look (sometimes) and on the right we have a schematic of the
screen where each view is represented by a rectangle with the name of the view.

To add a constraint simply click one of the circles on the sides of the view and drag it to where the element which will constraint
the view. For example, to constraint an ImmageView to the left of the screen simply drag the circle to the left of the screen.

<a href="https://imgbb.com/"><img src="https://image.ibb.co/hy9ZvQ/Screen_Shot_2017_07_28_at_11_34_30_PM.png" alt="Screen_Shot_2017_07_28_at_11_34_30_PM" border="0"></a><br />

The Attributes tab will look something like this:

<a href="https://ibb.co/nmgTpk"><img src="https://image.ibb.co/n9qM9k/Screen_Shot_2017_07_28_at_11_41_54_PM.png" alt="Screen_Shot_2017_07_28_at_11_41_54_PM" border="0"></a>

Feel free to play with the ConstraintLayout, you can refer to the [Android Developer's ConstraintLayout documentation](https://developer.android.com/training/constraint-layout/index.html)
to know more. You can also ask me!

At the end, the `holder_contact` layout will look something like this:

<a href="https://imgbb.com/"><img src="https://image.ibb.co/kyvopk/Screen_Shot_2017_07_28_at_11_47_25_PM.png" alt="Screen_Shot_2017_07_28_at_11_47_25_PM" border="0"></a>

Now we are ready to code!
