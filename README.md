# Kitten House Care

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=Checkout%20this%20@bitbucket%20repo%20by%20@joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB:%20https://bitbucket.org/jesperancinha/kitten-house-care-parent/src/master/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=BitBucket&message=Kitten%20House%20Care&color=informational)](https://bitbucket.org/jesperancinha/kitten-house-care-parent/src/master/) 
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/7a61b7f1783d4394a183d53c2564c728)](https://www.codacy.com/manual/jofisaes/kitten-house-care-parent?utm_source=jesperancinha@bitbucket.org&amp;utm_medium=referral&amp;utm_content=jesperancinha/kitten-house-care-parent&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/bb/jesperancinha/kitten-house-care-parent.svg?style=svg)](https://circleci.com/bb/jesperancinha/kitten-house-care-parent)
[![Build status](https://ci.appveyor.com/api/projects/status/jnsit0favwu0j0w0?svg=true)](https://ci.appveyor.com/project/jesperancinha/kitten-house-care-parent)
[![Bitbucket Pipelines branch](https://img.shields.io/bitbucket/pipelines/jesperancinha/kitten-house-care-parent/master)](https://bitbucket.org/jesperancinha/kitten-house-care-parent/addon/pipelines/home)

---
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/ )
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-50.png "Spring Framework")](https://spring.io/projects/spring-framework)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-boot-50.png "Spring Boot")](https://spring.io/projects/spring-boot)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-webflux-50.png "Spring Webfllux")](https://spring.io/projects/spring-boot)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-reactor-50.png "Spring Reactor")](https://www.docker.com/)
---

# Introduction

Let's investigate WebFlux and the Reactive Programming paradigms.

In our example we are going to look at a cat care center.

>The center is responsible to find cats and kittens and register them. Wild cats in urban areas cannot fend for themselves and they deserve the best of a household. In this application we will allow a Cat Care Center (CCC) to manage these cats and keep a record of them. Considering that cats can live anything between [2 to 16 years](https://www.mcvoordieren.nl/hoe-oud-wordt-een-kat) in the wild, and all the way up to [38 years](https://en.wikipedia.org/wiki/Creme_Puff_\(cat\)) at home, it is important to keep their history. We also want to keep record of who owned them in the past and where have they lived as much as possible in order to assess their behaviour. At the same time we want to gather as much data as possible in orther to determine patterns in behaviour that may lead to certain health conditions.

For this exercise, it is important to understand that our focus is only on understanding Reactive Programming in action, detecting blocking calls using [Blockhound](https://github.com/reactor/BlockHound), and migrating a blocking application to a non-blocking application. 

If you try to run the build, the unit tests are breaking and the build doesn't work:

```bash
mvn clean install
```

In order to achieve the goal of this Hack Night, you just need to make sure that all 4 Getters work reactively:

```text
http://localhost:%d/cats/1
http://localhost:%d/cats/full/1
http://localhost:%d/cats
http://localhost:%d/cats/full
```


## Domain knowledge

-   [Meet Zuu – The Cat Who Embodies The Feeling When You Hear Your Alarm Clock Start Ringing](https://www.boredpanda.com/funny-exotic-long-hair-cat-zuu/)
-   [Zuu and Bocco](https://ourfunnylittlesite.com/meet-zuu-and-bocco-adorable-Bocco-cats-with-round-faces/)

## References

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
-   [Baeldung Spring WebFlux](https://www.baeldung.com/spring-webflux)
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

## About me 👨🏽‍💻🚀

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/acclaim-20.png "Acclaim")](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/instagram-20.png "Instagram")](https://www.instagram.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
