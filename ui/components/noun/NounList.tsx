import {FC} from "react"
import {useNouns} from "../../hooks/useNouns";
import {Noun} from "./Noun";

interface Props {}

export const NounList: FC<Props> = () => {
    const { nouns, loading } = useNouns()

    return (
        { nouns.map((noun) => (<Noun noun={noun} />))}
    )
}