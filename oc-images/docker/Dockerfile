FROM registry.access.redhat.com/ubi8/ubi-minimal:8.8

# Install required packages
RUN microdnf install -y curl tar gzip && microdnf clean all

# Install OpenShift CLI (oc) + kubectl
ENV OC_VERSION=4.14.0
RUN curl -LO https://mirror.openshift.com/pub/openshift-v4/clients/ocp/${OC_VERSION}/openshift-client-linux.tar.gz && \
    tar -zxvf openshift-client-linux.tar.gz -C /usr/local/bin/ oc kubectl && \
    chmod +x /usr/local/bin/oc /usr/local/bin/kubectl && \
    rm -f openshift-client-linux.tar.gz

# Install Helm
ENV HELM_VERSION=3.12.0
RUN curl -LO https://get.helm.sh/helm-v${HELM_VERSION}-linux-amd64.tar.gz && \
    tar -zxvf helm-v${HELM_VERSION}-linux-amd64.tar.gz && \
    mv linux-amd64/helm /usr/local/bin/helm && \
    chmod +x /usr/local/bin/helm && \
    rm -rf linux-amd64 helm-v${HELM_VERSION}-linux-amd64.tar.gz

# Set PATH and default command
ENV PATH=$PATH:/usr/local/bin
ENTRYPOINT ["/bin/bash"]
