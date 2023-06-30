class NotesApp {
    val archives: MutableList<Archive> = mutableListOf()
    var currentArchive: Archive? = null
    var currentNote: Note? = null

    fun run() {
        while (true) {
            val archivesMenu = ArchivesMenu(this)
            archivesMenu.show()

            val input = readLine()?.toIntOrNull()
            val shouldExit = archivesMenu.executeOption(input ?: -1)
            if (shouldExit) {
                break
            }
        }
    }

    fun createArchive() {
        println("Введите имя нового архива:")
        val name = readLine()
        if (name.isNullOrBlank()) {
            println("Недопустимое имя архива. Пожалуйста, попробуйте еще раз.")
        } else {
            val newArchive = Archive(name)
            archives.add(newArchive)
            println("Архив '$name' создан.")
        }
    }

    fun selectArchive(index: Int) {
        if (index in 1..archives.size) {
            currentArchive = archives[index - 1]
            while (true) {
                val notesMenu = NotesMenu(this)
                notesMenu.show()

                val input = readLine()?.toIntOrNull()
                if (notesMenu.executeOption(input ?: -1)) {
                    break
                }
            }
        } else {
            println("Неверный Ввод. Пожалуйста, введите правильный вариант.")
        }
    }

    fun addNoteToArchive(archive: Archive) {
        println("Введите текст новой заметки:")
        val noteText = readLine()
        if (noteText.isNullOrBlank()) {
            println("Неверный текст заметки. Пожалуйста, попробуйте еще раз.")
        } else {
            archive.notes.add(Note(noteText))
            println("Заметка добавлена в '${archive.name}'.")
        }
    }

    fun selectNoteInArchive(index: Int) {
        val archive = currentArchive
        if (archive != null && index in 1..archive.notes.size) {
            currentNote = archive.notes[index - 1]
            while (true) {
                val noteDetailMenu = NoteDetailMenu(this)
                noteDetailMenu.show()

                val input = readLine()?.toIntOrNull()
                if (noteDetailMenu.executeOption(input ?: -1)) {
                    break
                }
            }
        } else {
            println("Неверный Ввод. Пожалуйста, введите правильный вариант.")
        }
    }

    fun showNoteDetail() {
        val note = currentNote
        if (note != null) {
            println("Заметка:")
            println(note.text)
            println()
        }
    }
}


