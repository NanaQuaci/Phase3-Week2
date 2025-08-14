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


# Create directories with proper permissions
RUN mkdir -p allure-results target/surefire-reports && \
    chmod -R 777 allure-results target/surefire-reports \

# Run tests when container starts
CMD ["mvn", "test", "-Dmaven.test.failure.ignore=true", "-Dmaven.clean.skip=true"]