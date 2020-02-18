# Eonics Hack Night #21 Reactive programming met Spring Webflux

# Introduction

Let's investigate WebFlux and the Reactive Programming paradigms.

In our example we are going to look at a cat care center.

>The center is responsible to find cats and kittens and register them. Wild cats in urban areas cannot fend for themselves and they deserve the best of a household. In this application we will allow a Cat Care Center (CCC) to manage these cats and keep a record of them. Considering that cats can live anything between [2 to 16 years](https://www.mcvoordieren.nl/hoe-oud-wordt-een-kat) in the wild, and all the way up to [38 years](https://en.wikipedia.org/wiki/Creme_Puff_\(cat\)) at home, it is important to keep their history. We also want to keep record of who owned them in the past and where have they lived as much as possible in order to assess their behaviour. At the same time we want to gather as much data as possible in orther to determine patterns in behaviour that may lead to certain health conditions.

## Status

[Under construction...](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/UnderConstruction.md)


## Description

At the end of this session we will look into WebFlux exercises to complete.

## About this event (In Dutch)

Op 19 februari 2020 organiseert Eonics de 21ste Open Hack Night. Dit keer zal Eonics consultant João Esperancinha ons een introductie geven in Reactive programming met Spring Webflux.

Na de coding challenge van januari gaan we voor februari weer "back to the roots" met een ouderwetse hack night over een Java/Kotlin gerelateerd onderwerp, waarbij we natuurlijk ook zelf aan de slag gaan met de materie.

Zoals altijd regelen we eten en drinken, inclusief vegetarische en halal opties, maar neem wel je eigen laptop mee zodat je mee kan doen aan de workshop.

Alles op een rij

-   Waar: Eonics HQ
-   Wanneer: Woensdag 19 februari 2019
-   Wat: Reactive programming met Spring Webflux
-   Spreker: [João Esperancinha](jofisaes@gmail.com)
-   Hoe laat: inloop vanaf 17:00 uiterlijk 17:45 aanwezig
-   Eten & drinken is aanwezig, inclusief vegetarische & halal opties
-   Aanmelden: RSVP via Eventbrite

Voor vragen neem contact op met Chantal van der Kleij.

## Domain knowledge

-   [Meet Zuu – The Cat Who Embodies The Feeling When You Hear Your Alarm Clock Start Ringing](https://www.boredpanda.com/funny-exotic-long-hair-cat-zuu/)

## Where to sign in

-   [Eonics Hack Night #21 Reactive programming in Spring Webflux](https://www.eventbrite.com/e/tickets-eonics-hack-night-21-reactive-programming-in-spring-webflux-91585581941)


## Hints and trics

-  Typical settings on a .bashrc file to get Gradle, GitPrompt, SDKMAN and some handy aliases. 
```shell script
export GRADLE_HOME=/opt/gradle/gradle-6.1.1
export PATH=${GRADLE_HOME}/bin:${PATH}
alias ll='ls -l -a --color=auto'
if [ -f "/root/.bash-git-prompt/gitprompt.sh" ]; then
    GIT_PROMPT_ONLY_IN_REPO=1
    source /root/.bash-git-prompt/gitprompt.sh
fi

#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="/root/.sdkman"
[[ -s "/root/.sdkman/bin/sdkman-init.sh" ]] && source "/root/.sdkman/bin/sdkman-init.sh"
alias java13="sdk use java 13.0.2.hs-adpt"
alias java12="sdk use 12.0.2.hs-adpt"
alias java8="sdk use java 8.0.242.hs-adpt"
alias m2disable="rm ~/.m2/settings.xml"
alias m2enable="cp /your_repo_folder/settings.xml ~/.m2/"
```
## References

-   

## About me

[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social)](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social)](https://github.com/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=BitBucket&message=jesperancinha&color=navy)](https://bitbucket.org/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitLab&message=jesperancinha&color=navy)](https://gitlab.com/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED)](http://joaofilipesabinoesperancinha.nl)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=DEV&message=Profile&color=green)](https://dev.to/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Medium&message=@jofisaes&color=green)](https://medium.com/@jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Hackernoon&message=@jesperancinha&color=green)](https://hackernoon.com/@jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Free%20Code%20Camp&message=jofisaes&color=008000)](https://www.freecodecamp.org/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Hackerrank&message=jofisaes&color=008000)](https://www.hackerrank.com/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Forces&message=jesperancinha&color=008000)](https://codeforces.com/profile/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Coder%20Byte&message=jesperancinha&color=008000)](https://coderbyte.com/profile/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Wars&message=jesperancinha&color=008000)](https://www.codewars.com/users/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Acclaim%20Badges&message=joao-esperancinha&color=red)](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Google%20Apps&message=Joao+Filipe+Sabino+Esperancinha&color=orange)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Pen&message=jesperancinha&color=orange)](https://codepen.io/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Docker%20Images&message=jesperanciha&color=099CEC)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/DockerImages.md)
