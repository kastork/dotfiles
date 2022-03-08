#! /usr/bin/env groovy

String scheme
String uri

(scheme, uri) =  args[0].split("://")

def slugs = uri.split('/')

def shard = slugs[2]
def user = slugs[4]
def guid = slugs[5]

println "evernote:///view/$user/$shard/$guid/$guid/"
