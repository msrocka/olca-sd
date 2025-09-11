# olca-sd

This (experimental) project links system dynamics (SD) with LCA models. The idea is that SD models can be directly loaded in openLCA. The parameters of an SD model can be then linked to parameters of an openLCA product system. The combined model can be then executed in a simulation. In each simulation step it passes the calculated SD parameters into the LCA model which is then evaluated with these parameter values. It would then produce a sequence of parameter and LCA results.

## Status

+ [x] Read SD models from the [XMILE format](https://docs.oasis-open.org/xmile/xmile/v1.0/os/xmile-v1.0-os.html)
+ [x] Equation parser and evaluator
+ [x] Basic simulator
+ [x] Basic support for arrays
+ [ ] Advanced array functions
+ [ ] SVG visualisation
+ [ ] Basic integration in openLCA (sd-sim branch)
+ [ ] LCA model and parameter linking
+ [ ] Simulation and results


## Notes

+ Stella uses `dimensions` instead of `dims` in it's XMILE implementation
