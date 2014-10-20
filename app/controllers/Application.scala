package controllers

import com.wacai.csw.protocols.vo.UserInfo
import org.msgpack.MessagePack
import play.api.http.Writeable
import play.api.libs.iteratee.Enumerator
import play.api.mvc._

object Application extends Controller {

  val msgpack = new MessagePack()


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def stream = Action {
    //    Ok.chunked(Enumerator("afoo", "bones", "cheater").andThen(Enumerator.eof)).as("application/x-msgpack")

    val user1 = new UserInfo()
    user1.email = "test@wacai.com"

    val user2 = new UserInfo()
    user2.phone = "11111111111"

    implicit val writeable = new Writeable((user:UserInfo) => msgpack.write(user), Some("application/x-msgpack"))

    Ok.chunked(Enumerator(user1, user2).andThen(Enumerator.eof)).as("application/x-msgpack")
  }

}