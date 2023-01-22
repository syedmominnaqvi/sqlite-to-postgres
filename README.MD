# Start Here 
Assuming you have a Postgres instance already up,

1. Change any connection details in application.yaml file
2. Go to SqliteToPostgresApplication.java
3. Run the main method
4. After the server is up and running, use this curl command

curl --location --request POST 'http://localhost:9098/upload?file' \
--form 'file=@"/private/tmp/test.db"'

Please change the file location appropriately.