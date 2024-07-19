package tg.devsyril.myapplication.data.room.repositories

import kotlinx.coroutines.flow.Flow
import tg.devsyril.myapplication.data.room.daos.OTPCodeDao
import tg.devsyril.myapplication.data.room.models.OTPCode

class OTPCodeRepository(
    private val otpCodeDao: OTPCodeDao
) {
    suspend fun insert(otpCode: OTPCode) { otpCodeDao.insert(otpCode)}
    fun checkOtpCode(email: String, code: String): Flow<List<OTPCode>> = otpCodeDao.checkOtpCode(email, code)
}