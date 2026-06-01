import {
  MathJax
}
from "better-react-mathjax";

interface Props {

  text: string;

}

export default function MathRenderer({
  text
}: Props) {

  return (

    <MathJax dynamic>

      {text}

    </MathJax>

  );

}