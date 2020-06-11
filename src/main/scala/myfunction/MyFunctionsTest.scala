package myfunction

/**
 * Functions that return functions
 */
object MyFunctionsTest {

  def main(args: Array[String]): Unit = {
    val domainName = "www.example.com"

    def getURL = urlBuilder(ssl = true, domainName)

    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
    println(url)
  }

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }


}

