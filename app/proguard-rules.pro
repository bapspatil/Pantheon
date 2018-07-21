-ignorewarnings
# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

# BottomBar
-dontwarn com.roughike.bottombar.**

# Retrofit
-dontwarn okio.**
-dontwarn javax.annotation.**

-keep class com.google.gson.** { *; }
-keep class com.google.inject.** { *; }

-keep class org.apache.http.** { *; }
-keep class org.apache.james.mime4j.** { *; }

-keep class javax.inject.** { *; }
-keep class javax.xml.stream.** { *; }

-keep class retrofit.** { *; }

-keep class com.google.appengine.** { *; }

-keepattributes *Annotation*
-keepattributes Signature

-dontwarn com.squareup.okhttp.*
-dontwarn rx.**

-dontwarn javax.xml.stream.**
-dontwarn com.google.appengine.**
-dontwarn java.nio.file.**
-dontwarn org.codehaus.**

# AVLoadingIndicatorView
-keep class com.wang.avi.** { *; }
-keep class com.wang.avi.indicators.** { *; }

# Picasso
-dontwarn com.squareup.okhttp.**

# NineOldAndroids
-keep class com.nineoldandroids.animation.** { *; }
-keep interface com.nineoldandroids.animation.** { *; }
-keep class com.nineoldandroids.view.** { *; }
-keep interface com.nineoldandroids.view.** { *; }