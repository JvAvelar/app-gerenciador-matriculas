package dev.jvitor.gerenciadordematriculas.biometric

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG

class BiometricHelper {
    companion object {
        @SuppressLint("ObsoleteSdkInt")
        fun isBiometricAvailable(context: Context): Boolean {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
                return false
            }
            val biometricManager = BiometricManager.from(context)
            return when (biometricManager.canAuthenticate(BIOMETRIC_STRONG)) {
                BiometricManager.BIOMETRIC_SUCCESS -> true
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> false
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> false
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> false
                else -> false
            }
        }
    }
}