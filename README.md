# Atlas Deer Client #

This is the Atlas Deer Client Java SDK for making requests to atlas.metabroadcast.com

### How do I get set up? ###

In order to use this add the following to your maven dependencies:

```
<dependency>
    <groupId>org.atlasapi.deer.client</groupId>
    <artifactId>atlas-deer-client</artifactId>
    <version>${atlas-deer-client.version}</version>
</dependency>

<repositories>
    <repository>
        <id>metabroadcast-mvn</id>
        <name>Metabroadcast</name>
        <url>http://mvn.metabroadcast.com/all</url>
        <layout>default</layout>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>true</enabled>
        </releases>
    </repository>
</repositories>

```

### What has been done? ###

Warning: This version of the client is WIP.

It does not support all endpoints and HTTP verbs and it is not guaranteed to work correctly for all applications.

The following endpoints have been implemented:

* /content.json


### Example Usage ###


```
#!java

AtlasReadClient client = new AtlasClient(
        "https", HostSpecifier.fromValid("atlas.metabroadcast.com"), "api-key"
);

ContentQuery query = ContentQuery.get()
        .addAnnotations(Annotation.DESCRIPTION)
        .addSource("source")
        .addLimit(10);

ContentResponse contentResponse = client.getContent(query);
```
