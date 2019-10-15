
## Lotto Analysis System

### Base Docker Image

* [jin3670/gintire](https://hub.docker.com/r/jin3670/gintire)


### Installation

1. Install [Docker](https://www.docker.com/).

2. Download [automated build](https://registry.hub.docker.com/u/dockerfile/elasticsearch/) from public [Docker Hub Registry](https://registry.hub.docker.com/): `docker pull jin3670/gintire:1.0.1`


### Usage

    docker run -d -p 8080:8080 jin3670/gintire:1.0.1

#### Customized Image

  1. Create a jdbc.property file on the host.
    ```properties
    Globals.DriverClassName=com.mysql.jdbc.Driver
    Globals.Url=jdbc:mysql://<localhost>:3306/lotto
    Globals.username=<id>
    Globals.password=<password>
    ```

  2. In some environments, it may make more sense to prepare a custom image containing your configuration. A `Dockerfile` to achieve this may be as simple as:
    ```sh
    FROM jin3670/gintire:1.0.1
    MAINTAINER jinwook.im <jin3670@gmail.com>
    COPY jdbc.properties /usr/local/tomcat/webapps/
    ```
   3. You could then build and try the image with something like:
   ```sh
   $ docker build --tag=gintire-custom .
   $ docker run -it --rm jin3670/gintire-custom
   ```
   5. 
After few seconds, open `http://<host>:8080` to see the result.
