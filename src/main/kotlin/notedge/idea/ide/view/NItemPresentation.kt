package notedge.idea.ide.view

import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

@Suppress("MemberVisibilityCanBePrivate")
class NItemPresentation(val icon: Icon, val text: String?, val detail: String? = null) : ItemPresentation {
    override fun getPresentableText(): String? = text
    override fun getIcon(unused: Boolean): Icon = icon
    override fun getLocationString(): String? = detail
}