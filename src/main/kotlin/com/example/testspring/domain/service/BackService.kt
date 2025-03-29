package com.example.testspring.domain.service

import com.example.testspring.domain.entity.Back
import com.example.testspring.domain.entity.Db
import com.example.testspring.domain.entity.Front
import com.example.testspring.domain.repository.BackRepository
import com.example.testspring.domain.repository.DbRepository
import org.slf4j.Logger
import com.example.testspring.domain.repository.FrontRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BackService(
    val backRepository: BackRepository,
    val frontRepository: FrontRepository,
    val dbRepository: DbRepository
) {
    val log : Logger = LoggerFactory.getLogger(this::class.java)
    fun testAdd(){
        var back = Back(body = "back")

        back = backRepository.save(back)

        var front : Front = Front(domain = "front connect back#"+back.id, back = back)

        var db : Db = Db(dbPort = "3306 connect back#"+back.id, back = back)

        frontRepository.save(front)
        dbRepository.save(db)
    }

    @Transactional(readOnly = true)
    fun testCompare1() : Boolean{
        log.info("1")
        val front = frontRepository.findFrontById(1)!!
        val db = dbRepository.findDbById(1)!!
/*log

//        log.info((front.domain + " " + front.back!!.id))
//        log.info((db.dbPort + " " + db.back!!.id))
*/

        if(front.back != db.back) {
            return false;
        }else{
            return true;
        }

    }

    fun testCompare2() : Boolean{
        log.info("2")
        val front = frontRepository.findFrontById(1)!!
        val db = dbRepository.findDbById(1)!!
/* log
        log.info((front.domain + " " + front.back!!.id))
        log.info((db.dbPort + " " + db.back!!.id))

*/
        if(front.back != db.back) {
            return false;
        }else{
            return true;
        }

    }

    fun testCompare3() : Boolean{
        log.info("3")
        val front = frontRepository.findFrontById(1)!!
        val db = dbRepository.findDbById(1)!!
        /* log
                log.info((front.domain + " " + front.back!!.id))
                log.info((db.dbPort + " " + db.back!!.id))

        */
        if(front.back!!.id != db.back!!.id) {
            return false;
        }else{
            return true;
        }
    }

    @Transactional
    fun testCompare4() : Boolean{
        log.info("4")
        val front = frontRepository.findFrontById(1)!!
        val db = dbRepository.findDbById(1)!!
        /* log
                log.info((front.domain + " " + front.back!!.id))
                log.info((db.dbPort + " " + db.back!!.id))

        */
        if(front.back!!.body != db.back!!.body) {
            return false;
        }else{
            return true;
        }
    }
}