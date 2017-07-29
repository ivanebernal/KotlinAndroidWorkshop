# Intents

Commit number: 4a78984

## A note on photos

We have our list almost ready! If you want to add some custom photos, just import images as drawables. 
My favorite tool to do that is a plugin for Android Studio called Batch Drawable Import. You can download it on __Preferences__ > __Plugins__ > __Browse repositories__ 
and searching for __Android Drawable Importer__.

When you right-click the drawable folder and select new, an option at the borrom of the menu called _Batch Drawable Import_ will appear.

<a href="https://ibb.co/f679Uk"><img src="https://preview.ibb.co/ifRQ25/Screen_Shot_2017_07_29_at_2_04_49_AM.png" alt="Screen_Shot_2017_07_29_at_2_04_49_AM" border="0"></a><br />

A window like this will appear and when you click on the plus button, the window to select the image will appear and 
then a configurations window will prompt. Click ok and you'll have your image on the drawable folder.
ven
<a href="https://ibb.co/kZT85Q"><img src="https://preview.ibb.co/d7wHzk/Screen_Shot_2017_07_29_at_2_17_54_AM.png" alt="Screen_Shot_2017_07_29_at_2_17_54_AM" border="0"></a><br />
Be sure to limit your ImageView size!

## TODO?

If we run our app and click on one of our contacts, the app will crash. Why? Because we haven't implemented the `onContactSelected`
method. Let's make the app open the phone dialer when we click a contact. For this we need an Intent. 

An Intent is an abstract description of an action to be performed. In this case our action is defined by the `Intent` class field
`ACTION_DIAL`

Let's replace that TODO line with the following:

```kotlin
val phoneNumber = contact.phoneNumber
val phoneIntent = Intent(Intent.ACTION_DIAL)
phoneIntent.data = Uri.parse( "tel:$phoneNumber")
startActivity(phoneIntent)
```
In that snippet we are adding data to the intent, that data is in the form of a Uri which contains the phone number of the
contact we clicked. The method `startActivity` "fires" the intent and the dialer app is called.

If we wanted to start an activity of our app with an intent we would have to write something like:

```kotlin
val intent = Intent(this, MyActivity::class.java)
startActivity(intent)
```

But that will be your homework!
