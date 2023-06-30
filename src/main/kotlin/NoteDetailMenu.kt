class NoteDetailMenu(private val app: NotesApp) {
    private val menu = Menu()

    init {
        menu.addItem("Показать заметку") { app.showNoteDetail(); false }
        menu.addItem("Выход") { true }
    }

    fun show() {
        menu.show()
    }

    fun executeOption(option: Int): Boolean {
        return menu.executeOption(option)
    }
}

