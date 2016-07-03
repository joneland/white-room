# White Room

## Build

Create uberjars for app and stub

`cd <project_root>/app ; lein uberjar`

`cd <project_root>/stub; lein uberjar`

## Deploy

`cd <project_root> ; docker-compose up -d`

## Execute behaviour tests

`cd <project_root>/app ; lein test :behaviour`
