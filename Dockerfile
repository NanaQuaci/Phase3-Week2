FROM maven:3.9.6-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Install Node.js and npm
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs

# Install Allure CLI
RUN npm install -g allure-commandline --save-dev

# Copy your project files into the image
COPY pom.xml .

# Download all Maven dependencies in advance
RUN mvn dependency:go-offline

# Copy the rest of the project
COPY src ./src
COPY allure-results ./allure-results

# Run tests when container starts
CMD mvn clean test && \
    mkdir -p allure-report && \
    allure generate allure-results --clean -o allure-report