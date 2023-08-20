import { INoun } from '../interfaces'
import useSWR from 'swr'

interface UseNounsResponse {
  nouns: INoun[]
  error: string
  loading: boolean
}

export const useNouns = (): UseNounsResponse => {
  // TODO fix api backend to point to correct be port
  const { data, error, isLoading } = useSWR('http://localhost:8080/api/nouns')

  return {
    nouns: data,
    error,
    loading: isLoading,
  }
}
