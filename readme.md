# Shiv
> An experimental dependency injection framework

# TLDR
- tiny, fast, Dependency Injection framework
- compile-time error checking
- no annotations, no "magic"
- zero* library dependencies

## What is this?
shiv takes method references (java lambdas) and organizes calls to them in such a way where method dependencies are supplied recursively

## What are all the package modules?
shiv is split up into packages:
- **shiv-api** is the project's API
- **shiv-core** is the runtime version of shiv
  - it is small and it and the api what you shade into your project
- **shiv-analyzer** is used in *your* tests at compile time to check for circular dependencies
  - it uses jgrapht but only at compile time (no shading)

## How do i use this?
- create a class implementing ``shiv.Module``
- make a function that returns *something*
- make a function that returns *otherthing* and depends on the *something* returned by the last function
- wherever you want to use *otherthing* without writing ``new OtherThing(new Something());``
  - write ``Shiv shiv = Shiv.provide(new YourModuleHere())``
  - call ``Otherthing other = shiv.build().get(Otherthing.class)``

## Probably, don't use this.
i made this for my robotics team some time ago as a proof of concept, as well as to avoid having to teach a full dependency injection framework like Google Guice and all of it's annotations. Nowadays, more modern alternatives such as Google's [Dagger2](https://github.com/google/dagger) framework seems to implement compile time generation (Although I believe it still uses some reflection and the jakarta standard annotations), so you should probably use the library with a nonzero maintainer count, haha

## I still want to use this
don't say I didn't warn you...
```
 maven {
    url "https://repo.superyuuki.com/releases"
 }
```
