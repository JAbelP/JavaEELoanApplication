FROM airhacks/glassfish
COPY ./target/LoanApp.war ${DEPLOYMENT_DIR}
