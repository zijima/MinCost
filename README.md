MinCost
=======

min cost problem using Goldberg CS2

Question:

Consider a DAG formed on the set of natural numbers [1::10000] with a directed arc from i to j if i divides j. Implement a program to find the maximum number of nodes
(numbers) covered by at most 23 node-disjoint paths. (Hint: reduce the problem to min-cost flow and use Goldberg's CS2).

1. download source code from http://www.igsystems.com/cs2/
2. compile the source code using "make"
3. run the java code
4. copy the "sample.inp" file to cs2-4.6 folder
5. call "cat sample.inp | ./cs2.exe"
6. then you can the result, like:

c CS 4.6
c Commercial use requires a licence
c contact igsys@eclipse.net
c
c nodes:           20002     arcs:           113668
c scale-factor:       12     cut-off-factor:  117.1
c
c time:             0.33     cost:             -223
c refines:             2     discharges:     242314
c pushes:         361388     relabels:       152412
c updates:             7     u-scans:         46004
c p-refines:           3     r-scans:         18535
c dfs-scans:      200020     bad-in:        0  +  0


If you have any problems, contact maziji7883@gmail.com
