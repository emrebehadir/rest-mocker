# Rest Mocker

Rest mocker is annotation based a lightweight mock rest api library for Android. It is compatable with OkHttp. Library lets you specify which responses to return. You can check [demo application](https://github.com/emrebehadir/rest-mocker-sample).

## Installation

In your project's `build.gradle`:
```gradle
allprojects {
    repositories {
        ....
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
dependencies {
    implementation 'com.github.emrebehadir:rest-mocker:0.0.1-alpha'
}
```

## Quick Start

### Initialize Library

Library must be initialize with `application resources`. It reads your raw response files.

```kotlin
    RestMocker.initialize(resources)
```

### Add OkHttpClient Interceptor

RestMockerInterceptor analyze your rest call and decide which api will be mock.

```kotlin
    val httpClient = OkHttpClient.Builder()
                .addInterceptor(RestMockerInterceptor())
                .build()
```

### Applying an Annotation

`@Mocker` specify which function will return mock response.

```kotlin
    @Mocker(rawResourceId = R.raw.todo)
    @GET("/todos/1")
    fun getTodo(): Call<ApiResponse>
```

### Where Is The Location Of Mock Response ?

Put your files to res/raw.

```
    App
    |
    -> res
      |
      -> sample_response.tx
      -> ...   
```

## License

```
Copyright 2020 Emre Behadır

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
