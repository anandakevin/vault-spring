# Variables
REGISTRY ?=  # Allow overriding in GitHub Actions or via command line
REPOSITORY ?= vault-spring
ENV ?= LOCAL  # Allow ENV to be overridden (defaults to LOCAL)

# Detect the architecture (local vs CI)
LOCAL_ARCH := $(shell uname -m)

# Set PLATFORM and IMAGE_TAG based on environment (local or CI)
ifeq ($(ENV),)
    ENV := DEV  # Default to DEV if ENV is not set
endif

# Set platform based on environment and architecture
ifeq ($(ENV), LOCAL)
    PLATFORM =      # No platform defined for local (will be handled by Docker default)
    IMAGE_TAG := latest-$(LOCAL_ARCH)  # Tag based on local architecture
else
    PLATFORM = linux/amd64  # For DEV/PROD, use amd64 platform
    IMAGE_TAG := $(IMAGE_TAG)  # Tag based on amd64 architecture for CI
endif

# Build, tag, and push the Docker image
docker-build-push:
	DOCKER_BUILDKIT=0 docker build \
		$(if $(PLATFORM),--platform $(PLATFORM)) \
		--build-arg ENV=$(ENV) \
		$(if $(REGISTRY),--tag $(REGISTRY)/$(REPOSITORY):$(IMAGE_TAG)) \
		--tag $(REPOSITORY):$(IMAGE_TAG) .  # Tag without REGISTRY for local
	$(if $(REGISTRY),docker push $(REGISTRY)/$(REPOSITORY):$(IMAGE_TAG),)  # Push only if REGISTRY is set

# Local build target (for ARM64 architecture or default local configuration)
docker-build-local:
	$(MAKE) docker-build-push ENV=LOCAL

# Local environment build (with push)
docker-build-push-local:
	$(MAKE) docker-build-push ENV=LOCAL REGISTRY=901450389408.dkr.ecr.ap-southeast-3.amazonaws.com

# DEV environment build (with push)
docker-build-push-dev:
	$(MAKE) docker-build-push ENV=DEV REGISTRY=$(REGISTRY)

# PROD environment build (with push)
docker-build-push-prod:
	$(MAKE) docker-build-push ENV=PROD REGISTRY=$(REGISTRY)
