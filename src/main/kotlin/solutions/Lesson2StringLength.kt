package solutions

import api.Task

class Lesson2StringLength : Task {
    override fun run(data: List<String>): String {
        return data.firstOrNull()?.length.toString()
    }
}