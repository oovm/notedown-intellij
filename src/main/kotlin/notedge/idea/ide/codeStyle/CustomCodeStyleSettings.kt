package notedge.idea.ide.codeStyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class CustomCodeStyleSettings(settings: CodeStyleSettings?) : CustomCodeStyleSettings(
    "NCustomCodeStyleSettings",
    settings
)
