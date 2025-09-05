# olca-sd

This is an experimental project for running system dynamics (SD) models in openLCA. The idea is that SD models can be directly loaded into openLCA. The parameters of an SD model can be then linked to parameters of openLCA. The user could add product systems to the simulation setup, that should be calculated in each simulation step. The reference amounts of these systems could be also linked to parameters of the SD model. More detailed parameter bindings for the selected product systems could be also possible. The user can then run the SD model directly in openLCA. In each simulation step, it would calculate the bounded product systems with the respective parameter values of that step. It would collect the stock values but also the LCIA results of the product systems for each simulation step.


+ https://github.com/bfix/dynamo/tree/master
+ https://uh-ir.tdl.org/server/api/core/bitstreams/786150c5-f2d3-42ea-a6e0-e114a3ca75d3/content
+ https://github.com/SDXchange/SDXlate/tree/gh-pages/models
+ https://www.oasis-open.org/standard/xmile1-0/


## Phase 1

Read models from [XMILE](http://docs.oasis-open.org/xmile/xmile/v1.0/xmile-v1.0.html) documents. We will not implement the full XMILE standard but start with a usable sub-set.


## Phase 2

Develop an expression parser and interpreter.


## Phase 3

Implement one or more solvers for SD models.


## Phase 4

Implement a first GUI version and make the parameter connection with openLCA.


## Backlog

+ Model check
  + Check dependencies of expressions: referenced variables must exist as
    stock, aux, or flow
