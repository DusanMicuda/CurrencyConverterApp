# Currency Converter App

Currency Converter App is an mobile app that allows users to convert between different currencies
and view the exchange rates. It uses the [Frankfurter API](https://www.frankfurter.app/)
to fetch the latest currency data, and the conversions.

## Introduction

I created this app as a personal project to practice my mobile development skills and to learn 
Kotlin Multiplatform Mobile (KMM) and other libraries. I wanted to create a useful app that can 
help users who travel or deal with foreign currencies. I also wanted to try out Compose Multiplatform,
which is a new way of building UIs for multiplatform apps.

## Installation

You can simply clone the repository with:
```
git clone https://github.com/DusanMicuda/CurrencyConverterApp.git
```
or you can download [androidApp-debug.apk](https://github.com/DusanMicuda/CurrencyConverterApp/blob/main/androidApp/build/outputs/apk/debug/androidApp-debug.apk) 
and install it on your android device.

## Technical Information

This app is written in Kotlin Multiplatform with UI in Compose Multiplatform, thanks to what it is 
usable on both Android and iOS devices with a single codebase. But these technologies are still young,
so I had to use some third-party libraries like Voyager or Moko Resources, which I'll explain
below.

### Architecture

I decided to use clean architecture, because it's my favorite, but according to small size of the app.
I didn't split the code into modules (data, domain, presentation,...), but I divided it only in packages.
I also didn't use domain layer because there isn't much business logic to do in use cases.

For presentation layer I used the MVI pattern which is the best for UI's in Compose in my opinion.\
With MVI is the code more safe, because only things that are public in view model is viewState
with specific data for screen and the `onEvent` function that handles occurred events from screen.

### Dependency Injection

For the dependency injection I used Koin, because it has good compatibility with KMM projects

### Ktor

Ktor is a kotlin based framework to call HTTP services which makes it best choice to use in KMM
project.

### Voyager

For the navigation between screens I used Voyager. Voyager is a multiplatform navigation library,
which allows to easily navigate between screens, it also offers so called `ScreenModel` which is 
multiplatform equivalent for `Android ViewModel`. There is also other features like `Tab` navigation
or `BottomSheet` navigation.

### Moko Resources

Moko Resources is a Kotlin Multiplatform library that allows to share resources like strings or
images for both Android and iOS platforms.

## Conclusion

I hope you enjoyed this app and found it useful. I would love to hear your feedback, suggestions,
or questions. You can contact me at micudasoftware@gmail.com or follow me on [LinkedIn](https://www.linkedin.com/in/dušan-mičuda-33b755212).
You can also check out my other projects.