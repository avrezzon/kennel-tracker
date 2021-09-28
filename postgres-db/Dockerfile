FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB kennel-tracker
COPY data.sql /docker-entrypoint-initdb.d/
