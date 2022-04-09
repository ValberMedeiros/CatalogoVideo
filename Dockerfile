FROM openjdk:11
RUN useradd -ms /bin/bash gradle
USER gradle
VOLUME "/usr/local/.gradle"
WORKDIR /usr/local/gradle