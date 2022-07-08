package notedge.idea.language.psi

open class ParsingStackItem {
    class Code: ParsingStackItem() {

    }
    class Asterisk(val level: Int): ParsingStackItem() {

    }
}