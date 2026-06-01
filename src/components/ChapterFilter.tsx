interface Props {

  onChange:
    (chapter: string)
      => void;

}

export default function ChapterFilter({
  onChange
}: Props) {

  return (

    <select
      onChange={(e) =>
        onChange(
          e.target.value
        )
      }
      className="
      border
      p-2
      rounded
      "
    >

      <option value="">
        All Chapters
      </option>

      <option value="Quadratic Equations">
        Quadratic Equations
      </option>

      <option value="Trigonometry">
        Trigonometry
      </option>

      <option value="Polynomials">
        Polynomials
      </option>

    </select>

  );
}