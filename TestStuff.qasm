OPENQASM 2.0;
include "qelib1.inc";

qreg q[3];
creg c[3];

h q[0];
u(pi/2,pi/2,pi/2) q[1];
u(pi/2,pi/2,pi/2) q[2];
id q[1];
h q[2];
sdg q[0];
y q[2];
u(pi/2,pi/2,pi/2) q[2];
h q[1];