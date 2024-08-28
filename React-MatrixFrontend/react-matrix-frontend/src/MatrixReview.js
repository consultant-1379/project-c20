import React from 'react'
import { useLocation } from 'react-router-dom'
import {Card, Table} from 'react-bootstrap'

export default function MatrixReview() {
    const {state} = useLocation()
    const matrix = state.matrix
    const rowStringPoints = ["Individualist", "Predictive", "Iterative", "Collaborative", "Experimental"]
    console.log(matrix)
    return (
        <Card>
            <Card.Header>Cloud Native Maturity Matrix Overview</Card.Header>
            <Card.Body>

            <Table  hover>

        <thead >
            <tr >
            <td>Stage</td>
            <td></td>
            <td><strong>NO PROCESS</strong></td>
            <td></td>
            <td><strong>WATERFALL</strong></td>
            <td></td>
            <td><strong>AGILE</strong></td>
            <td></td>
            <td><strong>CLOUD NATIVE</strong></td>
            <td></td>
            <td><strong>NEXT</strong></td>
            </tr>
            </thead>
        <tbody >
        {matrix.map((row, index) => {
                console.log(row)
                return (
                    <tr >
                        <td><strong>{row.stage}</strong></td>
                        {row.stringForRow.map((rowString, index) => {
                            console.log(index, row.rowLocationPoint)
                            return (
                                <>
                                <td className={index + 0.5 < row.rowLocationPoint ? "activeTableCell" : "nonActiveTableCell"}>{"      "}</td>
                                <td className={index + 0.5 < row.rowLocationPoint ? "activeTableCell" : "nonActiveTableCell"}>{rowString}</td>
                                </>
                            )
                        })}
                    </tr>
                )
            })}
        </tbody>
            

            </Table>
            </Card.Body>
            
        </Card>
    )
}
