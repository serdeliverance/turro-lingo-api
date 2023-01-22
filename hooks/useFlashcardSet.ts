import { useEffect, useState } from 'react'
import { IFlashCardSet } from '../interfaces'

export const useFlashcardSet = () => {
  const [flashcardSet, setFlashcardSet] = useState<IFlashCardSet | null>(null)
  const [error, setError] = useState(null)
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    setLoading(true)
    // TODO use await instead
    fetch('data/phrases.json')
      .then((response) => response.json())
      .then((data) => {
        console.log(data)

        setFlashcardSet({
          subject: 'German Phrases 101',
          language: 'German',
          flashcards: data,
        })
        setLoading(false)
      })
      .catch((err) => {
        setLoading(false)
        setError(err)
      })
  }, [])

  return {
    flashcardSet,
    loading,
    error,
  }
}
