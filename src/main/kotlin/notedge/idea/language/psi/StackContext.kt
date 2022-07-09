package notedge.idea.language.psi

enum class StackContext(val id: Int) {
    TEXT(0),
    CODE(1),
    STRING(2)
    ;

    fun intoID() = this.id

    companion object {
        fun fromID(id: Int): StackContext {
            val out = values().firstOrNull { it.id == id };
            return out!!
        }
    }
}