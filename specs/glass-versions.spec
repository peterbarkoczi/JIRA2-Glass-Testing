Glass Versions Specification
============================

Created by ligetimark on 2020. 02. 06.

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

| version_name                                                                                                                       |
|------------------------------------------------------------------------------------------------------------------------------------|
| "new version that should not ever exist by any means, please do not call your version like this, it is solely for testing purpose" |

* Go to main page
* Log in with valid credentials

Glass versions test
-------------------
Tags: glass

Compareing Glass versions with Project settings' versions

* Go to Project Settings page
* Select Versions submenu
* Create a new version named <version_name>

* Go to Glass page
* Select Versions Tab
* Version named <version_name> is available in Glass
______________
Teardown steps

* Go to Project Settings page
* Select Versions submenu
* Delete version named <version_name>
* Log out