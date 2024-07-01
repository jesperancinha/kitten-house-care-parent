# Kitten House Care

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=Checkout%20this%20@bitbucket%20repo%20by%20@joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB:%20https://github.com/jesperancinha/kitten-house-care-parent/src/master/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Kitten%20House%20Care%20🐱&color=informational)](https://github.com/jesperancinha/kitten-house-care-parent) 
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![CircleCI](https://circleci.com/bb/jesperancinha/kitten-house-care-parent.svg?style=svg)](https://circleci.com/bb/jesperancinha/kitten-house-care-parent)
[![Build status](https://ci.appveyor.com/api/projects/status/jnsit0favwu0j0w0?svg=true)](https://ci.appveyor.com/project/jesperancinha/kitten-house-care-parent)
[![KHC Build on PR](https://github.com/jesperancinha/kitten-house-care-parent/actions/workflows/kitten-hc-pull-request.yml/badge.svg)](https://github.com/jesperancinha/kitten-house-care-parent/actions/workflows/kitten-hc-pull-request.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b7c544d2f59644249ba624b8bd6cdd74)](https://www.codacy.com/gh/jesperancinha/kitten-house-care-parent/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/kitten-house-care-parent&amp;utm_campaign=Badge_Grade)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/b7c544d2f59644249ba624b8bd6cdd74)](https://www.codacy.com/gh/jesperancinha/kitten-house-care-parent/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/kitten-house-care-parent&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/kitten-house-care-parent/badge.svg?branch=main)](https://coveralls.io/github/jesperancinha/kitten-house-care-parent?branch=main)
[![codecov](https://codecov.io/github/jesperancinha/kitten-house-care-parent/branch/main/graph/badge.svg?token=NMKeAhTQOt)](https://codecov.io/github/jesperancinha/kitten-house-care-parent)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/kitten-house-care-parent.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/kitten-house-care-parent.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/kitten-house-care-parent.svg)](#)

---

## Technologies used

Please check the [TechStack.md](TechStack.md) file for details.

## Introduction

Let's investigate WebFlux and the Reactive Programming paradigms.

In our example we are going to look at a cat care center.

>The center is responsible to find cats and kittens and register them. Wild cats in urban areas cannot fend for themselves and they deserve the best of a household. In this application we will allow a Cat Care Center (CCC) to manage these cats and keep a record of them. Considering that cats can live anything between [2 to 16 years](https://www.mcvoordieren.nl/hoe-oud-wordt-een-kat) in the wild, and all the way up to [38 years](https://en.wikipedia.org/wiki/Creme_Puff_\(cat\)) at home, it is important to keep their history. We also want to keep record of who owned them in the past and where have they lived as much as possible in order to assess their behaviour. At the same time we want to gather as much data as possible in orther to determine patterns in behaviour that may lead to certain health conditions.

For this exercise, it is important to understand that our focus is only on understanding Reactive Programming in action, detecting blocking calls using [Blockhound](https://github.com/reactor/BlockHound), and migrating a blocking application to a non-blocking application. 

#### Stable releases

| Version  - Git-Tag                                                            | Git Hash                                                                                                         | Purpose                                                                                                                                                                     |
|-------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [0.0.1](https://github.com/jesperancinha/kitten-house-care-parent/tree/0.0.1) | [b714979c87cac22d5435f6aaa3ea1fd8031ae992](https://github.com/jesperancinha/kitten-house-care-parent/tree/0.0.1) | Java with JDK17 and Lombok - [Making reactive applications with a Kitten Care Example](https://joaofilipesabinoesperancinha.nl/blog/blog6-reactive-with-kittens/index.html) |
| [1.0.0](https://github.com/jesperancinha/kitten-house-care-parent/tree/1.0.0) | [57f8cfd4fdc5cc80eed6bbd29d73bc72c0b36ac7](https://github.com/jesperancinha/kitten-house-care-parent/tree/1.0.0) | Kotlin with JDK17 - [Making reactive applications with a Kitten Care Example](https://joaofilipesabinoesperancinha.nl/blog/blog6-reactive-with-kittens/index.html)          |

## How to run
This project has been tested with Java version 17:

```bash
sdk install java 17-open
sdk use java 17-open
```

You can use this comand to build the Java dependencies

```bash
mvn clean install
```

Or this one to build everything from root:

```bash
make build
```

## Generation steps

```shell
ln -s package/kitten-house-care-web kitten-house-care-web
```

## Running profiles

-  Default profile

```shell
mvn clean install
```

-   Report profile

```shell
mvn clean -Preports jacoco:prepare-agent install jacoco:report 
```

## References

-   [Select in coroutines](https://kt.academy/article/cc-select)
-   [How To Use Server-Sent Events in Node.js to Build a Realtime App](https://www.digitalocean.com/community/tutorials/nodejs-server-sent-events-build-realtime-app)
-   [Angular and Server Sent Events (SSE)](https://bartoszgajda.com/2019/12/22/angular-and-server-sent-events-sse/)
-   [Server-Sent Events Using Spring](https://dzone.com/articles/server-sent-events-using-spring)
-   [WebSockets - friend or foe? How to achieve real-time experience in your web application](https://nexocode.com/blog/posts/websockets-friend-or-foe/)
-   [What’s new in Java 17](https://medium.com/javarevisited/whats-new-in-java-17-e94b033ef211)
-   [SdkMan!](https://sdkman.io/)
-   [Why does ForkJoinPool::invoke() block the main thread?](https://stackoverflow.com/questions/52591776/why-does-forkjoinpoolinvoke-block-the-main-thread)
-   [Flight of the Flux 1 - Assembly vs Subscription](https://spring.io/blog/2019/03/06/flight-of-the-flux-1-assembly-vs-subscription)
-   [Hanselminutes Podcast 198 - Reactive Extensions for .NET (Rx) with Erik Meijer](https://www.hanselman.com/blog/HanselminutesPodcast198ReactiveExtensionsForNETRxWithErikMeijer.aspx)
-   [Reactive Extensions](https://docs.microsoft.com/en-us/previous-versions/dotnet/reactive-extensions/hh242985(v=vs.103)?redirectedfrom=MSDN)
-   [Reactive Programming by Venkat Subramaniam](https://www.youtube.com/watch?v=weWSYIUdX6c)
-   [The Essence of Reactive Programming - TU Delft Repositories](https://repository.tudelft.nl/islandora/object/uuid:bd900036-40f4-432d-bfab-425cdebc466e/datastream/OBJ/download)
-   [Notes on Reactive Programming Part I: The Reactive Landscape by Dave Syer](https://dzone.com/articles/notes-on-reactive-programming-part-i-the-reactive)
-   [The essence of reactive programming in Java by Uladzimir Sinkevich](https://www.scnsoft.com/blog/java-reactive-programming)
-   [Don't be Homer Simpson with your reactor by Sergei Egorov](https://www.slideshare.net/Pivotal/dont-be-homer-simpson-with-your-reactor)
-   [Avoid Reactor Meltdown by Phil Clay on YouTube](https://www.youtube.com/watch?v=xCu73WVg8Ps)
-   [Avoiding Reactor Meltdown by Phil Clay](https://github.com/philsttr/avoiding-reactor-meltdown)
-   [JsonView Chrome Plugin](https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc)
-   [Spring WebFlux Tutorial](https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/)
-   [Wiremock Running as a Standalone Process](http://wiremock.org/docs/running-standalone/)
-   [Move your apps to the cloud in weeks](https://pivotal.io/application-modernization)
-   [The Twelve Factors](https://12factor.net/)
-   [DDD and Microservices: Like Peanut Butter and Jelly - Matt Stine](https://content.pivotal.io/slides/ddd-and-microservices-like-peanut-butter-and-jelly-matt-stine)
-   [Reactive Streams](http://www.reactive-streams.org/)
-   [Reactive Manifesto](https://www.reactivemanifesto.org/)
-   [NLJUG Reactive Programming](https://nljug.org/java-magazine/reactive-programming/)
-   [Hands on Reactive Programming in Spring](https://www.bol.com/nl/p/hands-on-reactive-programming-in-spring-5/9200000084600333/?bltgh=pCsqVROC1Zv4I9xR0JRJfw.1.4.ProductTitle)
-   [QPI Architecture](https://en.wikipedia.org/wiki/Intel_QuickPath_Interconnect)
-   [ITNext How to make legacy code reactive](https://itnext.io/how-to-make-legacy-code-reactive-2debcb3d0a40)
-   [Spring 5 Reactive Security Example](https://github.com/eugenp/tutorials/tree/master/spring-5-reactive-security)
-   [Block Hound](https://github.com/reactor/BlockHound)
-   [Lombok Tips And Tricks](https://github.com/piczmar/lombok-tips-and-tricks)
-   [In spring boot webflux based microservice, who is the subscriber?](https://stackoverflow.com/questions/48181801/in-spring-boot-webflux-based-microservice-who-is-the-subscriber)
-   [How REST endpoints are auto subscribed while calling from Browser/REST Client?](https://stackoverflow.com/questions/50795071/how-rest-endpoints-are-auto-subscribed-while-calling-from-browser-rest-client)
-   [Reactive Programming with Node.js](https://www.amazon.com/Reactive-Programming-Node-js-Fernando-Doglio/dp/1484221516)
-   [Spring Data R2DBC](https://spring.io/projects/spring-data-r2dbc)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
