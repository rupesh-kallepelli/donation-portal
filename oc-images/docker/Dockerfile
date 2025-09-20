FROM registry.access.redhat.com/openshift3/ose-cli:v4.12

# Install Helm (v3)
ADD https://get.helm.sh/helm-v3.12.0-linux-amd64.tar.gz /tmp/helm-v3.12.0-linux-amd64.tar.gz
RUN tar -zxvf /tmp/helm-v3.12.0-linux-amd64.tar.gz -C /tmp && \
    mv /tmp/linux-amd64/helm /usr/local/bin/helm && \
    chmod +x /usr/local/bin/helm && \
    rm -rf /tmp/linux-amd64 /tmp/helm-v3.12.0-linux-amd64.tar.gz && \
    oc version && helm version

ENTRYPOINT ["/bin/bash"]
