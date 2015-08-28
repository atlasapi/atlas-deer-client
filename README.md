# Atlas Deer Client #

This is the Atlas Deer Client Java SDK for making requests to atlas.metabroadcast.com

### How do I get set up? ###

This is current WIP and has not yet been deployed to the Maven repos. When it is you will be able to import it as follows.

In order to use this add the following to your maven dependencies:

```
<dependency>
    <groupId>org.atlasapi.deer.client</groupId>
    <artifactId>atlas-deer-client</artifactId>
    <version>${atlas-deer-client.version}</version>
</dependency>

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
