package com.Rishabh Prajapati.photoalbum.utils

import android.content.Context
import com.Rishabh Prajapati.photoalbum.R
import com.Rishabh Prajapati.photoalbum.addon.AddOnManager
import com.Rishabh Prajapati.photoalbum.addon.AddOnType
import com.Rishabh Prajapati.photoalbum.context.IContextManager
import com.Rishabh Prajapati.photoalbum.network.model.Error

object ErrorUtils {
    /**
     * Create no connectivity error.
     * @return no connectivity error
     */
    fun noConnectivity() : Error {
        var code: Int? = 0
        var body: String? = ""

        val contextManager: IContextManager? = AddOnManager.getAddOn(AddOnType.CONTEXT_MANAGER) as IContextManager?
        val context: Context? = contextManager?.getContext()

        code = context?.resources?.getInteger(R.integer.error_code_no_connectivity)
        body = context?.resources?.getString(R.string.error_body_no_connectivity)

        return Error(code, body)
    }
}