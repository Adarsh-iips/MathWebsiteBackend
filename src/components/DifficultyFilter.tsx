interface Props {

  onChange:
    (difficulty: string)
      => void;

}

export default function DifficultyFilter({
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
        All Difficulties
      </option>

      <option value="Easy">
        Easy
      </option>

      <option value="Medium">
        Medium
      </option>

      <option value="Hard">
        Hard
      </option>

    </select>

  );
}