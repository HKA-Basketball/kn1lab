# Aufgabe 1

sudo ./keygen.sh
sudo ./mininet_1.py

CLIENT1: ssh c1
SERVER1: ssh sv1

SERVER1: iperf3 -s
SERVER1: cpunetlog -l 
CLIENT1: iperf3 -c 10.11.0.3 -Z -t 60 

cnl_plot.py /tmp/cpunetlog/<Log> -nsc 0.001 
summary.py /tmp/cpunetlog/<Log> 


# Aufgabe 2

sudo ./mininet_1.py

CLIENT1: ssh c1
CLIENT2: ssh c2
SERVER1: ssh sv1

SERVER1: iperf3 -s -B 10.11.0.3 
SERVER1: iperf3 -s -B 10.12.0.3
SERVER1: cpunetlog -l 
CLIENT1: iperf3 -c 10.11.0.3 -Z -t 60 
CLIENT2: iperf3 -c 10.12.0.3 -Z -t 60 

cnl_plot.py /tmp/cpunetlog/<Log> -nsc 0.001 
summary.py /tmp/cpunetlog/<Log> 

SERVER1: cpunetlog -l 
CLIENT1: iperf3 -c 10.11.0.3 -Z -t 60 
CLIENT2: iperf3 -c 10.12.0.3 -Z -u -b 800k -t 60 

cnl_plot.py /tmp/cpunetlog/<Log> -nsc 0.001 
summary.py /tmp/cpunetlog/<Log> 


# Aufgabe 3

sudo ./mininet_2.py

CLIENT1: ssh c1
SERVER1: ssh sv1

SERVER1: iperf3 -s
SERVER1: cpunetlog -l 
CLIENT1: iperf3 -c 10.11.0.3 -Z -t 60 

cnl_plot.py /tmp/cpunetlog/<Log> -nsc 0.001 
summary.py /tmp/cpunetlog/<Log> 


# Aufgabe 4

sudo ./mininet_3.py

CLIENT1: ssh c1
SERVER1: ssh sv1

SERVER1: iperf3 -s
SERVER1: cpunetlog -l 
CLIENT1: cpunetlog -l 
CLIENT1: iperf3 -c 10.11.0.3 -Z -u -b 800k -t 60 
