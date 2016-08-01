FROM 6qat/java8

MAINTAINER Guilherme Ceschiatti <ceschiatti@gmail.com>

RUN wget -O - -o /dev/null http://get.takipi.com/takipi-t4c-installer | \
        bash /dev/stdin -i --sk=S11289#8pZ/8RxsUctZkgge#OU/5B64+hNcBEVljElrNakP3AEE0rnOO7ConmQAkP1s=#69c7

# Setup Takipi key and name
RUN /opt/takipi/etc/takipi-setup-machine-name my-takipi-machine


# TAKIPI Ticket number is #5649 EditClon