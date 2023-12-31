# Проект по тестированию API сайта "Shady Meadows"  
сделано в рамках дипломного проекта для qa.guru
 <p align="center">
<img title="smeadows" src="media/screen/rbp-logo.png" width="700">
</p>
> <a target="_blank" href="https://automationintesting.online/">automationintesting.online</a>
 


<a name="Ссылка"></a>
## Оглавление

- <a href="#tools">Использованный стек технологий</a>
- <a href="#list">Список проверок</a> 
- <a href="#jenkins">Запуск в Jenkins</a>
- <a href="#allure">Результаты запуска тестов в Allure</a>
- <a href="#testops">Интеграция с TestOps</a>
- <a href="#jira">Интеграция с Jira</a>
- <a href="#telegram">Отчет о результатах в Telegram</a> 

<p align="left">
<a id="tools"></a>
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media\logo\JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a> 
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a> 
<a href="https://web.telegram.org/"><img src="media\logo\Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://qameta.io/"><img src="media\logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
<a href="https://www.atlassian.com/software/jira"><img src="media\logo\Jira.svg" width="50" height="50" alt="Jira" title="Jira"></a>
</p>

Для написания проектов использовался язык **Java**. Среда сборки **IntelliJ IDEA** сочетается с **Gradle**.
**JUnit5** - фреймворк модульного тестирования.   Запуск тестов выполняется из **Jenkins**.  

**Allure Report**, **AllureTestOps** и **Telegram Bot** использованы для визуализации результатов проверок.


<a id="list"></a>
## :heavy_check_mark: Тест кейсы
- Проверка на успешную авторизацию
- Проверка на отправку сообщения 
- Проверка на неуспешную отправку сообщения при несоблюдении формата email
- Проверка на создание нового номера отеля
- Проверка на удаление созданного номера отеля


## <img src="media/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Задача в <a target="_blank" href="https://jenkins.autotests.cloud/job/C20-smeadows-ebtry2/">Jenkins</a>
<p align="center">
<a id="jenkins"></a>
<img title="Jenkins" src="media/screen/jenkinsScreen.PNG"> </p> 

> Jenkins позволяет удаленно запустить тест и генерирует Allure и TestOps отчетность



<a id="allure"></a>
## <img src="media/logo/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/C20-smeadows-ebtry2/allure/">Allure Report</a>
<p align="center">
<img title="Allure Overview" alt="Allure" src="media/screen/allure1.PNG">
</p>

<p align="center">
<img title="Allure" alt="Allure" src="media/screen/allure2.PNG"> </p> 

> Отчет позволяет детально посмотреть шаги выполнения тестов
 
 
 ## <img src="media/logo/Allure_TO.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://allure.autotests.cloud/project/3643/dashboards">Allure TestOps</a>
<p align="center">
<a id="testops"></a>
<img title="Allure Overview1" src="media/screen/testOpsScreen.png">
</p>

> Интеграция с TestOps позволяет выборочно или поточно запускать тесты
 

<a id="jira"></a>
## <img src="media/logo/Jira.svg" width="25" height="25"  alt="Jira"/></a> Отчет в <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-868">Jira</a>
<p align="center">
<img title="Jira" src="media/screen/jiraScreennew.PNG">
</p>

> Тест-кейсы и результаты прогонов можно прикреплять к задачам в Jira

<a id="telegram"></a>
## <img src="media/logo/Telegram.svg" width="25" height="25"  alt="Tg"/></a> Уведомление в Telegram при помощи бота
<p align="center">
<img title="tg" alt="Tg" src="media/screen/telega.jpg" width = "300"> </p> 

> Отчетность о результатах проверок в мессенджере Telegram

 
 